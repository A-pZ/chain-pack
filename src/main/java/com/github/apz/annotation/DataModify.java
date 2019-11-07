/**
 *
 */
package com.github.apz.annotation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.github.apz.model.operation.OperationType;

@Retention(RUNTIME)
@Target(METHOD)
/**
 * @author a-pz
 *
 */
public @interface DataModify {
	OperationType value();
}
