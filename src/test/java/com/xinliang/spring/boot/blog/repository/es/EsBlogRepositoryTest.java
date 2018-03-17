package com.xinliang.spring.boot.blog.repository.es;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import com.xinliang.spring.boot.blog.domain.es.EsBlog;

/**
 * EsBlog Repository 接口
 * 
 * @author liangxin
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsBlogRepositoryTest {
	@Autowired
	private EsBlogRepository esBlogRepository;

	@Before
	public void initRepositoryData() {
		// 清除所有数据
		esBlogRepository.deleteAll();

		esBlogRepository.save(new EsBlog("图书馆", "深圳的图书馆", "这是一个深圳的图书馆，里面好多人，天天要排队"));
		esBlogRepository.save(new EsBlog("田子坊", "上海田子坊", "第一次来上海田子坊，第一次看到原来小小的巷子会这么多人来，小月下领路"));
		esBlogRepository.save(new EsBlog("福田公司", "我上班的公司", "如果说IT很累，那么干外包的IT不仅仅是累，还有那种无归属感的疲惫"));
	}

	@Test
	public void testFindDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining() {
		
		Pageable pageable = new PageRequest(0, 20);
		String title = "田";
		String summary = "田子坊";
		String content = "小月下";
		
		Page<EsBlog> page = esBlogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(title, summary, content, pageable);
		
//		assertThat(page.getTotalElements()).isEqualTo(2);//使用断言，需要引入静态包
		
		System.out.println("---------------start-------------");
		for(EsBlog blog : page.getContent()) {
			System.out.println(blog.toString());
		}
		System.out.println("---------------end-------------");
	}
}
