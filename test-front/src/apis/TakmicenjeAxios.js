import axios from 'axios';

var TakmicenjeAxios = axios.create({
    baseURL: 'http://localhost:8080/api'

});

TakmicenjeAxios.interceptors.request.use(
    function success(config){
      const token = window.localStorage['jwt'];
      if (token){
        config.headers['Authorization'] = 'Bearer ' + token;
      }
      return config;
    }
  );
  
  
  

export default TakmicenjeAxios;