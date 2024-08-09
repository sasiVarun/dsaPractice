function fn() {

	karate.configure("report",{showLog:true, showAllSteps:true});
	karate.configure("ssl",{ trustAll: true });
	
	
	var config = {};
	var endpoint;
	var env = karate.properties["karate.environment"];
	
	karate.log(env);
	
	switch (env) {
		case "dev":
			endpoint = "https://reqres.in/api/users/";
			break;
		case "int":
			endpoint = "https://int.sample.url/";
			break;
		case "qa":
			endpoint = "https://qa.sample.url/";
			break;
		default:
			endpoint = "https://default.sample.url/";
	}
	config.ENDPOINT = endpoint
	
	return config;

}