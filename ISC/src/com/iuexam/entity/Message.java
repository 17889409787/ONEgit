package com.iuexam.entity;
/**
 * 
 * 消息持久化类
 *
 */
public class Message {
    private String sendname;  //发送消息者

    private String text;  //消息内容

    public String getSendname() {
        return sendname;
    }
    
    public void setSendname(String sendname) {
        this.sendname = sendname == null ? null : sendname.trim();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

	public String getMessage() {
		return "Message [sendname=" + sendname + ", text=" + text + "]";
	}

    }
