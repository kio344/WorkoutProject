package models.file;

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

	public static FileDao getInstance() {
		if (instance == null) {
			instance = new FileDao();
		}
		return instance;
	}
}
