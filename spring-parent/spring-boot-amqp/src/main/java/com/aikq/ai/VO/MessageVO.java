package com.aikq.ai.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 *  E
 * @author aikq
 * @date 2018年12月10日 14:54
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageVO implements Serializable {

	private Integer id;

	private Integer type;

	private String content;

	private String form;

	private String to;

	private Date createTime;
}
