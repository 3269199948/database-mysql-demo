package database.demo.vo;

import lombok.Data;

/**
 * 表字段结构
 * <p>
 * 某些字段不能遵循驼峰命名，因为是关键字
 * 暂时没有好的办法可以去手动映射值
 * 所以将就着吧...
 *
 * @author zhang
 * @version 1.0
 * @date 2021-6-4
 */
@Data
public class TableField {

    /**
     * 字段名
     */
    private String field;

    /**
     * 字段类型
     */
    private String type;

    /**
     * 是否为空
     */
    private String Null;

    /**
     * key
     */
    private String key;

    /**
     * 默认值
     */
    private String Default;

    /**
     * extra
     */
    private String extra;
}
