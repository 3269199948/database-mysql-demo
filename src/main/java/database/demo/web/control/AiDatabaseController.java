package database.demo.web.control;


import database.demo.entity.AiDatabase;
import database.demo.service.IAiDatabaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 数据库表 前端控制器
 * </p>
 *
 * @author zhang
 * @since 2021-06-04
 */
@Api(tags = "数据库管理")
@RestController
@RequestMapping(value = "/demo/ai-database", produces = MediaType.APPLICATION_JSON_VALUE)
public class AiDatabaseController {

    private final IAiDatabaseService iAiDatabaseService;

    public AiDatabaseController(IAiDatabaseService iAiDatabaseService) {
        this.iAiDatabaseService = iAiDatabaseService;
    }

    /**
     * 查询所有数据库信息
     *
     * @return 数据库列表
     */
    @ApiOperation(value = "查询所有数据库信息")
    @GetMapping(value = "queryAll")
    public ResponseEntity<List<AiDatabase>> queryAll() {
        return iAiDatabaseService.queryAll();
    }

    /**
     * 根据ID查询详情
     *
     * @param id id
     * @return 数据库信息
     */
    @ApiOperation(value = "根据ID查询详情")
    @GetMapping(value = "queryById/{id}")
    public ResponseEntity<AiDatabase> queryById(
            @ApiParam(value = "数据库ID") @PathVariable String id) {
        return iAiDatabaseService.queryById(id);
    }

    /**
     * 建立数据库连接
     *
     * @param id id
     * @return 结果
     */
    @ApiOperation(value = "建立数据库连接")
    @GetMapping(value = "connection/{id}")
    public ResponseEntity<String> connection(
            @ApiParam(value = "数据库ID") @PathVariable String id) {
        return iAiDatabaseService.connection(id);
    }
}
