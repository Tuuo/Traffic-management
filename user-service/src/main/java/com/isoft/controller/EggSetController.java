package com.isoft.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.isoft.entity.EggSet;
import com.isoft.entity.Maintain;
import com.isoft.service.EggSetService;
import com.isoft.service.MaintainService;
import com.isoft.utils.Result;
import com.isoft.vo.query.EggSetQueryVo;
import com.isoft.vo.query.MaintainQueryVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/eggSet")
public class EggSetController {

    @Resource
    private EggSetService maintainService;

    @GetMapping("/list")
    public Result getList(EggSetQueryVo groupQueryVo){
        //创建分页对象
        IPage<EggSet> page = new Page<EggSet>(groupQueryVo.getPageNo(), groupQueryVo.getPageSize());
        //调用分页查询方法
        maintainService.findRoleListByUserId(page, groupQueryVo);
        //返回数据
        return Result.ok(page);
    }

    @PostMapping("/add")
    public Result addGroup(@RequestBody EggSet group) {
        boolean save = maintainService.save(group);
        if (save){
            return Result.ok().message("添加成功");

        }
        return Result.error().message("添加失败");
    }
    @PutMapping("/update")
    public Result updateGroup(@RequestBody EggSet group){
        boolean b = maintainService.updateById(group);
        if (b){
            return Result.ok();

        }
        return Result.error();
    }
    @DeleteMapping("/delete/{id}")
    public Result deleteGroup(@PathVariable Integer id){
        if (maintainService.removeById(id)) {
            return Result.ok().message("删除成功");
        }
        return Result.error().message("删除失败");
    }
}
