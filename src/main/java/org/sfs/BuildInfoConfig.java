package org.sfs;

import java.io.InputStream;

import org.sfs.dto.BuildInfoDTO;
import org.sfs.dto.GitInfoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

public class BuildInfoConfig {
	final ObjectMapper mapper = new ObjectMapper();
    private static final Logger logger = LoggerFactory.getLogger(BuildInfoConfig.class);

    private static final String APP_NAME = "ms-provider-report";
    private static final String GIT_PROPERTIES_FILE = "git.properties";

	public BuildInfoDTO getBuildInfo() {
		BuildInfoDTO versionInfo = new BuildInfoDTO();
		versionInfo.setApplicationName(APP_NAME);
		try {
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(GIT_PROPERTIES_FILE);
			
			GitInfoDTO gitInfo = mapper.readValue(is, GitInfoDTO.class);
			
			versionInfo.setVersion(gitInfo.getBuildVersion());
			versionInfo.setLastBuild(gitInfo.getBuildTime().toString());
			
			String branchWithCommitId = String.format("%s %s",gitInfo.getCommitIdAbbrev(),gitInfo.getBranch());
			versionInfo.setBranchWithCommitId(branchWithCommitId);
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return versionInfo;
	}

    public BuildInfoConfig() {
    
    }   
}
