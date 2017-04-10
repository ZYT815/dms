package com.zyt.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.zyt.Const;
import com.zyt.entity.Document;
import com.zyt.entity.GroupPerson;
import com.zyt.entity.Person;
import com.zyt.service.IDocumentService;
import com.zyt.service.IPersonService;
import com.zyt.util.blob.IBlobBuilder;

@Controller
@RequestMapping("/document")
@SessionAttributes(Const.Attr.LOGIN_USER)
public class DocumentController {

	@Autowired
	private IBlobBuilder blobBuilder;
	@Autowired
	private IDocumentService documentService;
	@Autowired
	private IPersonService personService;

	private ResponseEntity<byte[]> innerDownload(Document document) throws IOException, SQLException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		headers.setContentDispositionFormData("attchment", document.getDname(), StandardCharsets.UTF_8);

		byte[] body = IOUtils.toByteArray(document.getDdata().getBinaryStream());

		return new ResponseEntity<>(body, headers, HttpStatus.OK);
	}

	@RequestMapping(value = "/download/{did}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> download(@PathVariable String did) throws IOException, SQLException {
		Document document = documentService.selectById(did);
		return innerDownload(document);
	}

	public ResponseEntity<byte[]> download(String did, String dpass) throws IOException, SQLException {
		Document document = documentService.selectById(did);
		if (document.getDid().equals(dpass))
			return innerDownload(document);
		else 
			return new ResponseEntity<>(HttpStatus.LOCKED);
	}

	@RequestMapping("/pass/${did}")
	public String pass(@PathVariable String did, Model model) {
		Document document = documentService.selectById(did);
		model.addAttribute(Const.Attr.DOUCMENT, document);
		return "/document/pass";
	}

	@RequestMapping("/delete/{did}")
	public String delete(@ModelAttribute(Const.Attr.LOGIN_USER) Person loginPerson, @PathVariable String did) {
		Document document = documentService.selectById(did);
		Set<GroupPerson> groupPersons = document.getGroup().getGroupPersons();
		groupPersons.retainAll(loginPerson.getGroupPersons());
		String gpid = groupPersons.stream().findFirst().get().getGpid();

		documentService.delete(document);
		return Const.REDIRECT + String.format("/document/index/%s", gpid);
	}

	@RequestMapping("/index/{gpid}")
	public String index(@ModelAttribute(Const.Attr.LOGIN_USER) Person loginPerson, @PathVariable String gpid,
			Model model) {
		// 更新用户相关的文档内容,现在重新查询用户并覆盖session中用户
		loginPerson = personService.selectByName(loginPerson.getPname());
		model.addAttribute(Const.Attr.LOGIN_USER, loginPerson);

		GroupPerson groupPerson = loginPerson.getGroupPersons().stream().filter(gp -> gp.getGpid().equals(gpid))
				.findFirst().get();
		Set<Document> documents = groupPerson.getGroup().getDocuments();
		model.addAttribute(Const.Attr.DOUCMENTS, documents);
		model.addAttribute(Const.Attr.PERMITTED, groupPerson.isPermitted());
		return "document/index";
	}

	@RequestMapping("/add/{gpid}")
	public String add(@PathVariable String gpid, Model model) {
		model.addAttribute(Const.Attr.GPID, gpid);
		return "document/add";
	}

	@RequestMapping(value = "/doAdd", method = RequestMethod.POST)
	public String doAdd(@ModelAttribute(Const.Attr.LOGIN_USER) Person loginPerson, MultipartFile file, String dpass,
			String gpid) throws IOException {
		byte[] bytes = file.getBytes();
		Document document = new Document();
		document.setDpass(dpass);
		document.setDdata(blobBuilder.builderBlob(bytes));
		document.setDname(file.getOriginalFilename());
		document.setGroup(loginPerson.getGroupPersons().stream().filter(gp -> gp.getGpid().equals(gpid)).findFirst()
				.get().getGroup());
		document.setUpdateDate(Calendar.getInstance().getTime());
		documentService.save(document);

		return Const.REDIRECT + String.format("/document/index/%s", gpid);
	}

}
