package com.crm.comcast.GenericUtilies;

public interface EndPointLibraray {
	String createProject="/addProject";
			String getAllproject="/projects";
			String getsingleproject="/projects/{projectId}";
			String updateproject="/projects/{projectId}";
			String deleteproject="/projects/{projectId}";

	
}
