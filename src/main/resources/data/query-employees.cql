MATCH (n:Employee) DETACH DELETE n;

MATCH (n:Employee) RETURN n LIMIT 35;
