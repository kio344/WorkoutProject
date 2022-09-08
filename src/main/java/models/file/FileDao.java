package models.file;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mysql.cj.result.Field;

import mybatis.Connection;

public class FileDao {
	private static FileDao instance = new FileDao();

	private FileDao() {
		// TODO Auto-generated constructor stub
	}

	public FileInfoDto insert(FileInfoDto file) {
		SqlSession session = Connection.getSession();

		session.insert("FileMapper.insert", file);

		session.commit();
		session.close();

		return file;
		
	}

	public FileInfoDto get(FileInfoDto file) {
		SqlSession session = Connection.getSession();

		FileInfoDto fileInfoDto = session.selectOne("FileMapper.get", file);

		session.close();

		return fileInfoDto;
		
	}
	public List<FileInfoDto> gets(FileInfoDto file){
		
		SqlSession session=Connection.getSession();
		
		List<FileInfoDto> list= session.selectList("FileMapper.gets",file);
		
		session.close();
		
	
		
		return list;
		
	}
	
	public void delete(FileInfoDto file) {
		SqlSession session=Connection.getSession();
		
		session.delete("FileMapper.delete",file);
		
		
		session.commit();
		session.close();
	}

	public static FileDao getInstance() {
		if (instance == null) {
			instance = new FileDao();
		}
		return instance;
	}
}
