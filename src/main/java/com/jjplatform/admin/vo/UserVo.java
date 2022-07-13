package com.jjplatform.admin.vo;

import com.jjplatform.admin.comm.vo.commonVo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserVo extends commonVo {
	private String compId;
	private String userId;
    private String userPass;
    private String userRole;
    private String userNm;
    private String telNo;
    private String email;
}
