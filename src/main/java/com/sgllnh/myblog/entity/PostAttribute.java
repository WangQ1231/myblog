package com.sgllnh.myblog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangqiang
 * @since 2024-04-12
 */
@TableName("post_attribute")
public class PostAttribute implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String content;

    private String editor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    @Override
    public String toString() {
        return "PostAttribute{" +
        "id = " + id +
        ", content = " + content +
        ", editor = " + editor +
        "}";
    }
}
