package com.neuedu.my12306.dao;

import java.util.List;

import com.neuedu.my12306.model.CertType;

public interface ICertTypeDao extends IBaseDao{
	/**
	 * 查找所有证件信息
	 * @param id 证件id
	 * @return 证件信息
	 */
	public List<CertType> findAll();
	/**
	 * 删除证件信息
	 * @return 删除成功返回true 删除失败返回false
	 */
	public boolean deleteCertType(CertType certType);
	/**
	 * 增加证件类型
	 * @return 增加成功返回true 增加失败返回false
	 */
	public boolean addCertType(CertType certType);
	/**
	 * 修改证件信息
	 * @return 修改成功返回true 修改失败返回false
	 */
	public boolean editCertType(CertType certType);
	
}
