package com.zhj.service;


import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.zhj.dao.PopedomDao;
import com.zhj.entity.ZhjPopedom;
import com.zhj.entity.ZhjPopedomTree;
import com.zhj.util.LevelUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class SysPopedomTreeService {

    @Autowired
    private PopedomDao popedomDao;

    /**
     * 根据用户权限获取左侧树
     * @param midList
     * @return
     */
    public List<ZhjPopedomTree> getAllPopedom(List<Integer> midList){
        List<ZhjPopedom> allPopedom = popedomDao.getAllPopedom(midList);
        List<ZhjPopedomTree>  popedomList = Lists.newArrayList();
        for (ZhjPopedom popedom: allPopedom) {
            popedomList.add(ZhjPopedomTree.adapt(popedom));
        }
        return popedomListToTree(popedomList);
    }
       //
        public List<ZhjPopedomTree> popedomListToTree(List<ZhjPopedomTree>  popedomList){
            if (CollectionUtils.isEmpty(popedomList)) {
                return Lists.newArrayList();
            }
            // level -> [aclmodule1, aclmodule2, ...] Map<String, List<Object>>
            Multimap<String, ZhjPopedomTree> levelPopedomMap = ArrayListMultimap.create();
            List<ZhjPopedomTree> rootList = Lists.newArrayList();
            for (ZhjPopedomTree zpt: popedomList ) {
                levelPopedomMap.put(zpt.getLevel(),zpt);
                if (LevelUtil.ROOT.equals(zpt.getLevel())) {
                    rootList.add(zpt);
                }
            }
            // 按照seq从小到大排序
            Collections.sort(rootList, new Comparator<ZhjPopedomTree>() {
                public int compare(ZhjPopedomTree o1, ZhjPopedomTree o2) {
                    return o1.getSeq() - o2.getSeq();
                }
            });
          // 递归生成树
            transformpopedomTree(rootList, LevelUtil.ROOT, levelPopedomMap);
            return rootList;
        }
    // level:0, 0, all 0->0.1,0.2
    // level:0.1
    // level:0.2
    public void transformpopedomTree(List<ZhjPopedomTree> popedomLevelList, String level, Multimap<String, ZhjPopedomTree> levelDeptMap) {
        for (int i = 0; i < popedomLevelList.size(); i++) {
            // 遍历该层的每个元素
            ZhjPopedomTree zhjPopedomTree = popedomLevelList.get(i);
            // 处理当前层级的数据
            String nextLevel = LevelUtil.calculateLevel(level, zhjPopedomTree.getMid());
            // 处理下一层
            List<ZhjPopedomTree> popedomList = (List<ZhjPopedomTree>) levelDeptMap.get(nextLevel);
            if (CollectionUtils.isNotEmpty(popedomList)) {
                // 排序
                Collections.sort(popedomList, popedomSeqComparator);

                zhjPopedomTree.setPopedomChildList(popedomList);
                // 进入到下一层处理
                transformpopedomTree(popedomList, nextLevel, levelDeptMap);
            }
        }

    }
    public Comparator<ZhjPopedomTree> popedomSeqComparator = new Comparator<ZhjPopedomTree>() {
        public int compare(ZhjPopedomTree o1, ZhjPopedomTree o2) {
            return o1.getSeq() - o2.getSeq();
        }
    };


}
