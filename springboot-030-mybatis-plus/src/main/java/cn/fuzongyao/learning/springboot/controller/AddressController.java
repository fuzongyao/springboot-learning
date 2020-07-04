package cn.fuzongyao.learning.springboot.controller;

import cn.fuzongyao.learning.springboot.entity.AddressDO;
import cn.fuzongyao.learning.springboot.entity.AddressNewDO;
import cn.fuzongyao.learning.springboot.service.AddressNewService;
import cn.fuzongyao.learning.springboot.service.AddressService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * <p></p>
 *
 * @author fuzongyao
 * @date 2019-10-29 23:17
 * @since 1.0
 */
@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;
    @Autowired
    private AddressNewService addressNewService;
    private Random random = new Random();

    @GetMapping("list")
    public List<AddressDO> list() {
        return addressService.list();
    }

    @GetMapping("page")
    public IPage<AddressDO> page() {
        return addressService.page(new Page<>(1, 10));
    }

    @PostMapping("insert")
    public AddressDO insert(AddressDO userDO) {
        addressService.save(userDO);
        return userDO;
    }

    @PostMapping("save")
    public String save() {
        long timeMillis = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            long currentTimeMillis = System.currentTimeMillis();
            for (int j = 0; j < 100; j++) {
                String areaId = random.nextInt(10000) + 1 + "";
                AddressDO addressDO = new AddressDO().setAreaId(areaId).setName(UUID.randomUUID().toString()).setType(random.nextInt(10));
                addressService.save(addressDO);
            }
            System.out.println("耗时：" + ((System.currentTimeMillis() - currentTimeMillis) / 1000.0));
        }
        System.out.println("总耗时：" + ((System.currentTimeMillis() - timeMillis) / 1000.0));
        return "success";
    }

    @PostMapping("saveNew")
    public String saveNew() {
        long timeMillis = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            long currentTimeMillis = System.currentTimeMillis();
            for (int j = 0; j < 100; j++) {
                String areaId = random.nextInt(10000) + 1 + "";
                AddressNewDO addressDO = new AddressNewDO().setAreaId(areaId).setName(UUID.randomUUID().toString()).setType(random.nextInt(10));
                addressNewService.save(addressDO);
            }
            System.out.println("New耗时：" + ((System.currentTimeMillis() - currentTimeMillis) / 1000.0));
        }
        System.out.println("New总耗时：" + ((System.currentTimeMillis() - timeMillis) / 1000.0));
        return "success";
    }

    @PostMapping("saveBatch")
    public String saveBatch() {
        long timeMillis = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            long currentTimeMillis = System.currentTimeMillis();
            List<AddressDO> list = new ArrayList<>(100000);
            for (int j = 0; j < 100000; j++) {
                String areaId = random.nextInt(10000) + 1 + "";
                AddressDO addressDO = new AddressDO().setAreaId(areaId).setName(UUID.randomUUID().toString()).setType(random.nextInt(10));
                list.add(addressDO);
            }
            addressService.saveBatch(list, 100000);
            System.out.println("耗时：" + ((System.currentTimeMillis() - currentTimeMillis) / 1000.0));
        }
        System.out.println("总耗时：" + ((System.currentTimeMillis() - timeMillis) / 1000.0));
        return "success";
    }

    @PostMapping("saveBatchNew")
    public String saveBatchNew() {
        long timeMillis = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            long currentTimeMillis = System.currentTimeMillis();
            List<AddressNewDO> list = new ArrayList<>(100000);
            for (int j = 0; j < 100000; j++) {
                String areaId = random.nextInt(10000) + 1 + "";
                AddressNewDO addressDO = new AddressNewDO().setAreaId(areaId).setName(UUID.randomUUID().toString()).setType(random.nextInt(10));
                list.add(addressDO);
            }
            addressNewService.saveBatch(list, 100000);
            System.out.println("New耗时：" + ((System.currentTimeMillis() - currentTimeMillis) / 1000.0));
        }
        System.out.println("New总耗时：" + ((System.currentTimeMillis() - timeMillis) / 1000.0));
        return "success";
    }

    @PostMapping("updateBatch")
    public String updateBatch() {
        return "success";
    }

    @PostMapping("delete")
    public String delete(Long id) {
        addressService.removeById(id);
        return "success";
    }
}
