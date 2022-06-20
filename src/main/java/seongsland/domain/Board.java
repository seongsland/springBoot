package seongsland.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Board implements Serializable {
	enum Category {
	   base;
	}
	
	private Long idx;
	private String title;
	private String content;
	private Category category;
	private LocalDateTime updateDate;
	private User user;
}
