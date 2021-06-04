package database.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import database.demo.entity.AiDatabase;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * <p>
 * 数据库表 服务类
 * </p>
 *
 * @author zhang
 * @since 2021-06-04
 */
public interface IAiDatabaseService extends IService<AiDatabase> {

    /**
     * 查询所有数据库信息
     *
     * @return 数据库列表
     */
    ResponseEntity<List<AiDatabase>> queryAll();

    /**
     * 根据ID查询详情
     *
     * @param id id
     * @return 数据库列表
     */
    ResponseEntity<AiDatabase> queryById(String id);

    /**
     * 建立数据库连接
     *
     * @param id id
     * @return 结果
     */
    ResponseEntity<String> connection(String id);
}
