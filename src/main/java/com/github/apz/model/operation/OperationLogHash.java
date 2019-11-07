/**
 *
 */
package com.github.apz.model.operation;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import java.util.stream.Collectors;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author a-pz
 *
 */
@Component
public class OperationLogHash {
	@Value("${chain-pack.signature.seed}")
	private String seed;

	public String hash(Object...args) {
       String result = Arrays.stream(args).map(arg -> base64(arg)).collect(Collectors.joining()) + seed;

       return DigestUtils.sha256Hex(result);
	}

	private String base64(Object o) {
		try (
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream( baos );
		) {

	        oos.writeObject( o );
	        oos.close();
	        return Base64.getEncoder().encodeToString(baos.toByteArray());
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
}
