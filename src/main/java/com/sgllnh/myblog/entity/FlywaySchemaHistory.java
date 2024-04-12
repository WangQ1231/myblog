package com.sgllnh.myblog.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangqiang
 * @since 2024-04-12
 */
@TableName("flyway_schema_history")
public class FlywaySchemaHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("installed_rank")
    private Integer installedRank;

    private String version;

    private String description;

    private String type;

    private String script;

    private Integer checksum;

    private String installedBy;

    private LocalDateTime installedOn;

    private Integer executionTime;

    private Byte success;

    public Integer getInstalledRank() {
        return installedRank;
    }

    public void setInstalledRank(Integer installedRank) {
        this.installedRank = installedRank;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public Integer getChecksum() {
        return checksum;
    }

    public void setChecksum(Integer checksum) {
        this.checksum = checksum;
    }

    public String getInstalledBy() {
        return installedBy;
    }

    public void setInstalledBy(String installedBy) {
        this.installedBy = installedBy;
    }

    public LocalDateTime getInstalledOn() {
        return installedOn;
    }

    public void setInstalledOn(LocalDateTime installedOn) {
        this.installedOn = installedOn;
    }

    public Integer getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Integer executionTime) {
        this.executionTime = executionTime;
    }

    public Byte getSuccess() {
        return success;
    }

    public void setSuccess(Byte success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "FlywaySchemaHistory{" +
        "installedRank = " + installedRank +
        ", version = " + version +
        ", description = " + description +
        ", type = " + type +
        ", script = " + script +
        ", checksum = " + checksum +
        ", installedBy = " + installedBy +
        ", installedOn = " + installedOn +
        ", executionTime = " + executionTime +
        ", success = " + success +
        "}";
    }
}
