import React from 'react';
import { moneyFormatter } from '../../util/moneyFormatter';
import './style.scss'
function CreditResultCard({ result }) {
    return (
        <table className='result'>
            <tr>
                <td className='result__tittle'>Credit Result:</td>
                <td>{result.creditResultType}</td>
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

export default CreditResultCard;
