-- ==============================================================
--  Index : PK_EMPLOYEES                                    
-- ==============================================================
CREATE INDEX PK_EMPLOYEES ON EMPLOYEES2(EMPLOYEEID)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_NORTHWIND
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : IX_EMPLOYEES_LASTNAME                                    
-- ==============================================================
CREATE INDEX IX_EMPLOYEES_LASTNAME ON EMPLOYEES2(LASTNAME)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_NORTHWIND
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : IX_EMPLOYEES_POSTALCODE                                    
-- ==============================================================
CREATE INDEX IX_EMPLOYEES_POSTALCODE ON EMPLOYEES2(POSTALCODE)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_NORTHWIND
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

