package com.github.apz.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public abstract class ChainPackDTO implements Serializable {
	private LocalDateTime insertTime;
	private LocalDateTime updateTime;

	public LocalDateTime getConvertedInsertTime() {
		if (Objects.isNull(insertTime)) {
			return null;
		}

		return insertTime.plusHours(9);
	}

	public LocalDateTime getConvertedUpdateTime() {
		if (Objects.isNull(updateTime)) {
			return null;
		}
		return updateTime.plusHours(9);
	}
}
