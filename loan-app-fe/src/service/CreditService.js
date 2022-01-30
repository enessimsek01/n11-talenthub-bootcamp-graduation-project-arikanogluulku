import axios from "axios";
const baseUrl = "http://localhost:8080/api/v1/credits";

class CreditService {
  createCredit(user) {
    return axios.post(baseUrl, user);
  }

  inquirtCredit(birthday,identificationNumber){
    return axios.get(baseUrl+`/inquiry?dateOfBirthday=${birthday}&identificationNumber=${identificationNumber}`)
  }
}

export default new CreditService();
