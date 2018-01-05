package nl.cimt.elastic_log;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

public class ElasticBean {

	/*public static void main(String[] args) throws IOException {
		ElasticBean elasticBean = new ElasticBean();
		elasticBean.sendToElastic();
	}*/
	public IndexResponse sendToElastic(Exchange exchange){
		String jsonString = exchange.getIn().getBody(String.class);
		RestHighLevelClient client = new RestHighLevelClient(
		        RestClient.builder(
		                new HttpHost("esb3.cgn.cimt.de", 9201, "http"),
		                new HttpHost("esb3.cgn.cimt.de", 9202, "http")));
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		/*jsonMap.put("user", "kimchy");
		jsonMap.put("postDate", new Date());
		jsonMap.put("message", "trying out Elasticsearch one more time");*/
		IndexRequest indexRequest = new IndexRequest("logtest_hari", "test");
		indexRequest.source(jsonString, XContentType.JSON);
		IndexResponse indexResponse = null;
		try {
			indexResponse = client.index(indexRequest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(indexResponse.getId());
		try {
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return indexResponse;
		
	}

}
