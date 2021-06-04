package database.demo.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>
 * 数据库表
 * </p>
 *
 * @author zhang
 * @since 2021-06-04
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
public class AiDatabase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 数据库ID
     */
    @ApiModelProperty(value = "数据库ID")
    private String id;

    /**
     * 数据库类型
     */
    @ApiModelProperty(value = "数据库类型")
    private String type;

    /**
     * 连接名
     */
    @ApiModelProperty(value = "连接名")
    private String connectionName;

    /**
     * 主机地址
     */
    @ApiModelProperty(value = "主机地址")
    private String ipAddress;

    /**
     * 端口号
     */
    @ApiModelProperty(value = "端口号")
    private Integer port;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;


}
