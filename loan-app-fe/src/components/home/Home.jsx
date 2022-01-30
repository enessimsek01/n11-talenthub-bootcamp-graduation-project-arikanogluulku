import React from 'react';
import HeaderImage from './HeaderImage';
import PageTittle from '../PageTittle/PageTittle';
import InquiryCredit from '../credit/InquiryCredit';
function Home() {
  return <div>
      <HeaderImage/>
      <PageTittle tittle ="inquire loan application"/>
      <InquiryCredit/>
  </div>;
}

export default Home;
