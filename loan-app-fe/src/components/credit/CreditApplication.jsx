import React, { useState } from 'react';
import Form from '../form/Form';
import CreditService from '../../service/CreditService';
import Modal from 'react-bootstrap/Modal';
import CreditResultCard from './CreditResultCard';
import PageTittle from '../PageTittle/PageTittle';
import './style.scss'
function CreditApplication() {
  const [show, setShow] = useState(false);
  const [data, setData] = useState({});
  const [error, setError] = useState(false);

  const  initialValues={
    name: "",
    surname: "",
    identificationNumber: "",
    dateOfBirthday: "",
    phone: "",
    salary: 0,
    guarantee: 0,
}
  const createCredit = (user) => {
    CreditService.createCredit(user)
      .then(response => setData(response.data))
      .catch(error => setError(true))
    clearForm();
  }
  const clearForm = () => {
    document.getElementById("form").reset();
  }


  const handleFormSubmit = (values) => {
    createCredit(values);
    setShow(true);
  }
  return <div className='credit'>
    <PageTittle tittle={"Credit Application"} />
    <Form handleFormsubmit = {handleFormSubmit}  initialValues={initialValues}  buttonName="Apply"/>
    <Modal
        show={show}
        onHide={() => setShow(false)}
        keyboard={false}
        centered
      >
        {
          !error ? (
            <>
              <PageTittle tittle="Your Loan Application Result" />
              <CreditResultCard result={data}/>
            </>
              ) :<h2>There was an error during your loan application.
              Try again.</h2>
        }

      </Modal>
  </div>;
}

export default CreditApplication;
