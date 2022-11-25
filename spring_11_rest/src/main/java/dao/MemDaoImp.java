package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import dto.MemDTO;

public class MemDaoImp implements MemDAO{
	
	private SqlSessionTemplate sqlSession;
	
	public MemDaoImp() {
	
	}
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<MemDTO> list() {	
		return sqlSession.selectList("mem.all");
	}

	@Override
	public MemDTO list(int num) {	
		return sqlSession.selectOne("mem.one", num);
	}

	@Override
	public MemDTO list(MemDTO dto) {		
		return sqlSession.selectOne("mem.search", dto);
	}

	@Override
	public void register(MemDTO dto) {
		System.out.printf("server insert: %s %d %s\n",dto.getName(), dto.getAge(), dto.getLoc());
		sqlSession.insert("mem.ins", dto);
		
	}

	@Override
	public void update(MemDTO dto) {
		sqlSession.update("mem.upt", dto);		
	}

	@Override
	public void delete(int num) {
		sqlSession.delete("mem.del", num);
		
	}
	
	

}
