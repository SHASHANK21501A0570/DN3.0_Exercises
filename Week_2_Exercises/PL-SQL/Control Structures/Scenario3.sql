DECLARE
  CURSOR c_due_loans IS
    SELECT l.LoanID, c.CustomerID, c.Name, l.LoanAmount, l.EndDate
    FROM Loans l
    JOIN Customers c ON l.CustomerID = c.CustomerID
    WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + INTERVAL '30' DAY;
BEGIN
  FOR rec IN c_due_loans LOOP
    DBMS_OUTPUT.PUT_LINE(
      'Reminder: Loan ID ' || rec.LoanID || ' for customer ' || rec.Name ||
      ' (Customer ID: ' || rec.CustomerID || ') is due on ' || TO_CHAR(rec.EndDate, 'YYYY-MM-DD') ||
      '. The loan amount is $' || rec.LoanAmount || '.'
    );
  END LOOP;
EXCEPTION
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Error occurred: ' || SQLERRM);
END;
/
