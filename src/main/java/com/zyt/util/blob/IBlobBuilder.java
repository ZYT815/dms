package com.zyt.util.blob;

import java.io.InputStream;
import java.sql.Blob;

public interface IBlobBuilder {

	java.sql.Blob builderBlob(byte[] bytes);

	Blob builderBlob(InputStream in, int length);

}
