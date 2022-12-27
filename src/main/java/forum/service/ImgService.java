package forum.service;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import forum.model.Img;
import forum.model.ImgDao;


public class ImgService {

	private ImgDao iDao;

	public ImgService() {
		this.iDao = new ImgDao();
	}

	public void save(Integer articleId, Map<String, Blob> imgMap) {

		List<Img> imgList = new ArrayList<Img>();
		Iterator<Entry<String, Blob>> entries = imgMap.entrySet().iterator();
		while (entries.hasNext()) {
			Img img = new Img();
			Map.Entry<String, Blob> entry = entries.next();
			img.setImgName(entry.getKey());
			img.setImg(entry.getValue());
			imgList.add(img);

		}

		iDao.save(articleId, imgList);
	}

	public List<Img> findByArticleId(Integer articleId) {
		return iDao.findByArticleId(articleId);
	}

	public Img findByImgNo(Integer imgNo) {
		return iDao.findByImgNo(imgNo);
	}

	public void deleteByArticleId(Integer articleId) {
		iDao.deleteByArticleId(articleId);
	}

	public void deleteByAImgNo(Integer imgNo) {
		iDao.deleteByImgNo(imgNo);
	}
	
	public void update(Img img) {
		iDao.update(img);
	}
	
}
