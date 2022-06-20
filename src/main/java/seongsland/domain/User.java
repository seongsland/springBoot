package seongsland.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User implements Serializable {
	private static final long serialVersionUID = 1;
	private Long idx;
	private String name;
	private String password;
	private String email;
	private LocalDateTime updateDate;
}
