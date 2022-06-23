package seongsland.test;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestService {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public String getTest(String testKey) {
		Map<String, String> result = sqlSession.selectOne("test.getTest", testKey);
		System.out.println(result);
		return result.getOrDefault("test_value", "");
	}
	
	@Transactional
	public String setTest() {
		sqlSession.delete("test.deleteTestAll");
		Map<String, String> insertMap	= new HashMap<>();
		insertMap.put("testKey", "test");
		insertMap.put("testValue", "테스트");
		sqlSession.insert("test.insertTest", insertMap);
		sqlSession.insert("test.insertTest", insertMap);
		return "1";
	}
}