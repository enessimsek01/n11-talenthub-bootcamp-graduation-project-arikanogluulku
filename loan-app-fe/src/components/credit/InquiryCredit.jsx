import React, { useState } from 'react';
import CreditService from '../../service/CreditService';
import Modal from 'react-bootstrap/Modal';
import FormInputItem from '../form/FormInputItem';
import PageTittle from '../PageTittle/PageTittle';
import CreditResultDetailCard from './CreditResulDetailCard';
function InquiryCredit() {
  const [show, setShow] = useState(false);
  const [dateOfBirthday, setDateOfBirthday] = useState('');
  const [identificationNumber, setIdentificationNumber] = useState('');
  const [result, setResult] = useState({})
  const [error, setError] = useState(false);

  const inquiryCredit = (birthday, idnumber) => {
    CreditService.inquirtCredit(birthday, idnumber)
      .then(response => {
        setResult(response.data)
        setError(false)
      })
      .catch(error => setError(true))
  }

  const handleClick = () => {
    inquiryCredit(dateOfBirthday, identificationNumber);
    setShow(true)
  }
  return <div className='credit'>
    <form id="inquiry-form" className="mx-2" >
      <FormInputItem label="Identification Number" type="text" name="identificationNumber" value={identificationNumber} onChange={(e) => setIdentificationNumber(e.target.value)} />
      <FormInputItem label="Birthday" type="date" name="dateOfBirthday" value={dateOfBirthday} onChange={(e) => setDateOfBirthday(e.target.value)} />
      <button className='form__button' type="button" onClick={handleClick}>Inquire</button>
    </form>
    <Modal
      show={show}
      onHide={() => setShow(false)}
      keyboard={false}
      centered
    >
      <PageTittle tittle="Your Credit Application Result" />
      {
        error ?
          (
            <h1 className='result__tittle'>There is no loan application suitable for the information entered.</h1>
          ) : (
           <CreditResultDetailCard result={result}/>
          )
      }
    </Modal>

  </div>;
}

export default InquiryCredit;
