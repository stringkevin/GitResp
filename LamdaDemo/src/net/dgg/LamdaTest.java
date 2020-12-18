package net.dgg;

import net.dgg.LamdaVO.LamdaVO;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


class Sss{
    public static void main(String[] args) {

            List<LamdaVO> lamdaVOList = new ArrayList<>();
            LamdaVO user1 = new LamdaVO(1, "Jay", "12324qq.com");
            LamdaVO user2 = new LamdaVO(2, "Addom", "12324qq.com");
            LamdaVO user3 = new LamdaVO(3, "Lee", "12324qq.com1");
            LamdaVO user4 = new LamdaVO(4, "Kevin", "12324qq.com2");

            lamdaVOList.add(user1);
            lamdaVOList.add(user2);
            lamdaVOList.add(user3);
            lamdaVOList.add(user4);

            //lamda表达式 过滤加遍历
            System.out.println("lamda表达式 过滤加遍历");
            lamdaVOList.stream().filter(u->u.getId()>2)
                    .forEach(u-> System.out.println(u.getId()+" "+u.getName()));
            //Map过滤
            Map<String, String> map = lamdaVOList.stream()
                    .collect(Collectors.toMap(LamdaVO::getName, LamdaVO::getEamil, (o, n) -> o));
            for (Map.Entry<String, String> entry : map.entrySet()) {
                    System.out.println(entry.getKey()+"---"+entry.getValue());
            }

            //lamda 表达式对对象里面某个属性提取List对象
            System.out.println("lamda 表达式对对象里面某个属性提取List对象");
            List<String> list = lamdaVOList.stream().map(LamdaVO::getName).collect(Collectors.toList());
            list.stream().forEach(s-> System.out.println(s));

            //lamda表达式变为map<String,List<String>>
            System.out.println("lamda表达式变为map<String,List<String>>");
            Map<String, List<LamdaVO>> map2 = lamdaVOList.stream().collect(Collectors.groupingBy(LamdaVO::getName));
            for (Map.Entry<String, List<LamdaVO>> entry : map2.entrySet()) {
                    System.out.println(entry.getKey()+"::"+entry.getValue());
    }

}



