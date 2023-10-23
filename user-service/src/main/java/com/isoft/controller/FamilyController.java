package com.isoft.controller;

import com.isoft.entity.Family;
import com.isoft.service.FamilyService;
import com.isoft.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/family")
public class FamilyController {
    @Resource
    private FamilyService familyService;

    @GetMapping("/list")
    public Result getList(){
        List<Family> list = familyService.list();
        return Result.ok(list);
    }

    @PostMapping("/add")
    public Result addFamily(@RequestBody Family family) {
        boolean save = familyService.save(family);
        if (save){
            return Result.ok().message("添加成功");

        }
        return Result.error().message("添加失败");
    }
    @PutMapping("/update")
    public Result updateFamily(@RequestBody Family family){
        boolean b = familyService.updateById(family);
        if (b){
            return Result.ok();

        }
        return Result.error();
    }
    @DeleteMapping("/delete/{id}")
    public Result deleteFamily(@PathVariable Integer id){
        if (familyService.removeById(id)) {
            return Result.ok().message("删除成功");
        }
        return Result.error().message("删除失败");
    }
}
