package kr.co.sist.service;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.co.sist.dao.EmpDAO;
import kr.co.sist.domain.EmpDomain;

/**
 * ���� ���� ó��
 * @author user
 *
 */
public class AjaxService {

	public String empJsonObj(int deptno) {
		
		//��ȸ ����� ����Ͽ� JSONObject���� ����
		JSONObject jsonObj = new JSONObject();
		
		EmpDAO eDAO = new EmpDAO();
		try {
			List<EmpDomain> list = eDAO.selectDeptEmp(deptno);
			jsonObj.put("resultFlag", true);
			jsonObj.put("dataSize", list.size());
			
			JSONArray jsonArr = new JSONArray();
			JSONObject jsonTemp = null;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			for( EmpDomain ed : list ) {
				//��ȸ ����� JSONObject�� ����
				jsonTemp = new JSONObject();
				jsonTemp.put("empno", ed.getEmpno());
				jsonTemp.put("ename", ed.getEname());
				jsonTemp.put("job", ed.getJob());
				jsonTemp.put("mgr", ed.getMgr());
				jsonTemp.put("hiredate", sdf.format(ed.getHiredate()));
				jsonTemp.put("sal", ed.getSal());
				jsonTemp.put("comm", ed.getComm());
				//�μ���ȣ�� ������ ȭ�鿡 �����ִ�.
				jsonArr.add(jsonTemp);
			}
			//JSONArray�� JSONObject�� �Ҵ�
			jsonObj.put("data", jsonArr);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return jsonObj.toJSONString();
	}
	
}//class
