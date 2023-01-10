SELECT p.ID, p.NAME, COUNT(ct.P_ID) as numOfCalls
FROM person as p 
LEFT JOIN call_trxn as ct on p.ID = ct.P_ID
GROUP BY p.NAME ORDER BY p.ID;
