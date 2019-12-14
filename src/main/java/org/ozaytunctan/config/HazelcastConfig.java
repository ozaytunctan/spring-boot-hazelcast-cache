package org.ozaytunctan.config;

import org.ozaytunctan.properties.HazelcastProperties;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.config.NetworkConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

@Configuration
public class HazelcastConfig {

//	@Bean
//	@ConfigurationProperties(prefix = "cache")
//	public HazelcastProperties hazelcastProperties() {
//		HazelcastProperties hazelcastProperties = new HazelcastProperties();
//		return hazelcastProperties;
//	}

	@Bean
	public Config config() {
//
//		 ClientConfig config = new ClientConfig();
//		 config.setInstanceName(hazelcastProperties.getName());
//		 config.getGroupConfig().setPassword(hazelcastProperties.getPassword());
//		 
//		 ClientConfig clientConfig = new ClientConfig();
//		 ClientNetworkConfig networkConfig = clientConfig.getNetworkConfig();
//		 networkConfig.addAddress("10.1.1.21", "10.1.1.22:5703")
//		         .setSmartRouting(true)
//		         .addOutboundPortDefinition("34700-34710")
//		         .setRedoOperation(true)
//		         .setConnectionTimeout(5000)
//		         .setConnectionAttemptLimit(5);
//		 String addresses[] = hazelcastProperties.getHostnames().split("#");
//		 config.getNetworkConfig().addAddress(addresses);
		
//		 HazelcastInstance instance = HazelcastClient.newHazelcastClient(config);

		
		
//		Config config = new Config();
//		GroupConfig groupConfig = config.getGroupConfig();
//		groupConfig.setName("dev");
//
//		NetworkConfig network = config.getNetworkConfig();
//		network.setPort(5701).setPortCount(20);
//		network.setPortAutoIncrement(true);
//
//		JoinConfig join = network.getJoin();
//		join.getMulticastConfig().setEnabled(false);
//		join.getTcpIpConfig().addMember("machine1").addMember("localhost").setEnabled(true);
//
		
		Config config=new Config();
		
		NetworkConfig network=new NetworkConfig();
                      network.setPort(5701).setPortCount(20);
                      network.setPortAutoIncrement(true);
        JoinConfig join=network.getJoin();
                   join.getMulticastConfig().setEnabled(true);
                   join.getTcpIpConfig().addMember("localhost").setEnabled(true);
        
                   config.getManagementCenterConfig().setEnabled(true);
                   config.getManagementCenterConfig().setUrl("http://localhost:9001/hazelcast");
                   
                   
		return config;

	}

	@Bean
	public HazelcastInstance hazelcastClient(Config clientConfig) {
		HazelcastInstance hzClient = Hazelcast.newHazelcastInstance(clientConfig);
		return hzClient;
	}

}
