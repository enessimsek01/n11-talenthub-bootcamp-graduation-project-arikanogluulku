import React from 'react';
import { moneyFormatter } from '../../util/moneyFormatter';
import './style.scss'
function CreditResulDetailCard({ result }) {
    return (
        <table className='result'>
            <tr>
                <td className='result__tittle'>Name:</td>
                <td>{result.name}</td>
            </tr>
            <tr>
                <td className='result__tittle'>Surname:</td>
                <td>{result.surname}</td>
            </tr>
            <tr>
                <td className='result__tittle'>Identification Number:</td>
                <td>{result.identificationNumber}</td>
            </tr>
            <tr>
                <td className='result__tittle'>Birthday:</td>
                <td>{result.dateOfBirthday}</td>
            </tr>
            <tr>
                <td className='result__tittle'>Phone:</td>
                <td>{result.phone}</td>
            </tr>
            <tr>
                <td className='result__tittle'>Result:</td>
                <td><span>{result.creditResultType}</span></td>
            </tr>
            {
                result.creditResultType !== "REJECTION" && (
                    <tr>
                        <td className='result__tittle'>Credit Limit:</td>
                        <td><span>{moneyFormatter.format(result.creditLimit)}</span></td>
                    </tr>
                )
            }
        </table>
    );
}

export default CreditResulDetailCard;
