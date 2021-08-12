;             
CREATE USER IF NOT EXISTS "SA" SALT '94981a2decaa68a7' HASH '4a56900a47eb1860f114daf0afe4ef174256c711f89c07f29602d84344ec40bf' ADMIN;         
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_B9FC34AE_4DEC_43CA_86F1_C390068C7AE1" START WITH 1 BELONGS_TO_TABLE;
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_2316479C_37CC_4855_A02E_708CBECEA439" START WITH 1 BELONGS_TO_TABLE;
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_145B6DC5_8C3F_41A4_A819_1D7F3D7A1427" START WITH 1 BELONGS_TO_TABLE;
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_407DDFBB_7BB0_4C01_A6DF_C10E58A9C662" START WITH 1 BELONGS_TO_TABLE;
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_CB53AA59_AD63_42D2_9039_3B5842AECFA0" START WITH 1 BELONGS_TO_TABLE;
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_CAAA3EEE_6E23_4908_95AD_A22111E53784" START WITH 1 BELONGS_TO_TABLE;
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_710F9729_6E16_46F1_9E43_10CB5A8C3D80" START WITH 1 BELONGS_TO_TABLE;
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_9FDB823C_DD28_4D7D_B0CE_D698F6B671E6" START WITH 1 BELONGS_TO_TABLE;
CREATE MEMORY TABLE "PUBLIC"."CITYS"(
    "CITY_CODE" BIGINT DEFAULT NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_2316479C_37CC_4855_A02E_708CBECEA439" NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_2316479C_37CC_4855_A02E_708CBECEA439",
    "CITY_DESCRIPTION" VARCHAR(200) NOT NULL,
    "CITY_DEPARTAMENT_CODE" BIGINT NOT NULL
);       
ALTER TABLE "PUBLIC"."CITYS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_3" PRIMARY KEY("CITY_CODE"); 
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.CITYS;   
CREATE MEMORY TABLE "PUBLIC"."CLIENTS"(
    "CLIENT_CODE" BIGINT DEFAULT NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_710F9729_6E16_46F1_9E43_10CB5A8C3D80" NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_710F9729_6E16_46F1_9E43_10CB5A8C3D80",
    "CLIENT_ADDRESS" VARCHAR(70) NOT NULL,
    "CLIENT_IDENTIFICATION_NUMBER" VARCHAR(20) NOT NULL,
    "CLIENT_IDENTIFICATION_TYPE" VARCHAR(5) NOT NULL,
    "CLIENT_NAME" VARCHAR(50) NOT NULL,
    "CLIENT_PHONE_NUMBER" VARCHAR(20) NOT NULL,
    "CLIENT_PICTURE" VARCHAR(255) NOT NULL,
    "CLIENT_CITY_CODE" BIGINT NOT NULL,
    "CLIENT_DEPARTAMENT_CODE" BIGINT NOT NULL
);   
ALTER TABLE "PUBLIC"."CLIENTS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_5" PRIMARY KEY("CLIENT_CODE");             
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.CLIENTS; 
CREATE MEMORY TABLE "PUBLIC"."DEPARTAMENTS"(
    "DEPARTAMENT_CODE" BIGINT DEFAULT NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_145B6DC5_8C3F_41A4_A819_1D7F3D7A1427" NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_145B6DC5_8C3F_41A4_A819_1D7F3D7A1427",
    "DEPARTAMENT_DESCRIPTION" VARCHAR(200) NOT NULL
);
ALTER TABLE "PUBLIC"."DEPARTAMENTS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_3E" PRIMARY KEY("DEPARTAMENT_CODE");  
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.DEPARTAMENTS;            
CREATE MEMORY TABLE "PUBLIC"."INVOICEDETAILS"(
    "INVOICE_ITEM_CONSECUTIVE" BIGINT DEFAULT NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_B9FC34AE_4DEC_43CA_86F1_C390068C7AE1" NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_B9FC34AE_4DEC_43CA_86F1_C390068C7AE1",
    "PRODUCT_CANT" INTEGER NOT NULL,
    "INVOICE_NUMBER" BIGINT NOT NULL,
    "PRODUCT_CODE" BIGINT NOT NULL
);          
ALTER TABLE "PUBLIC"."INVOICEDETAILS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_9" PRIMARY KEY("INVOICE_ITEM_CONSECUTIVE");         
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.INVOICEDETAILS;          
CREATE MEMORY TABLE "PUBLIC"."INVOICEHEADERS"(
    "INVOICE_NUMBER" BIGINT DEFAULT NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_CAAA3EEE_6E23_4908_95AD_A22111E53784" NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_CAAA3EEE_6E23_4908_95AD_A22111E53784",
    "INVOICE_ADDRESS" VARCHAR(50) NOT NULL,
    "INVOICE_DATE" TIMESTAMP NOT NULL,
    "INVOICE_TYPE" VARCHAR(15) NOT NULL,
    "INVOICE_PHONE" VARCHAR(20) NOT NULL,
    "INVOICE_TOTAL" DOUBLE NOT NULL,
    "INVOICE_CITY_CODE" BIGINT NOT NULL,
    "INVOICE_CLIENT_CODE" BIGINT NOT NULL,
    "INVOICE_DEPARTAMENT_CODE" BIGINT NOT NULL
);               
ALTER TABLE "PUBLIC"."INVOICEHEADERS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_6" PRIMARY KEY("INVOICE_NUMBER");   
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.INVOICEHEADERS;          
CREATE MEMORY TABLE "PUBLIC"."MATERIALS"(
    "MATERIAL_CODE" BIGINT DEFAULT NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_9FDB823C_DD28_4D7D_B0CE_D698F6B671E6" NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_9FDB823C_DD28_4D7D_B0CE_D698F6B671E6",
    "MATERIAL_DESCRIPTION" VARCHAR(150) NOT NULL,
    "MATERIAL_PRICE" DOUBLE NOT NULL
);  
ALTER TABLE "PUBLIC"."MATERIALS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_C" PRIMARY KEY("MATERIAL_CODE");         
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.MATERIALS;               
CREATE MEMORY TABLE "PUBLIC"."PRODUCTDETAILS"(
    "PRODUCT_DETAIL_CODE" BIGINT DEFAULT NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_407DDFBB_7BB0_4C01_A6DF_C10E58A9C662" NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_407DDFBB_7BB0_4C01_A6DF_C10E58A9C662",
    "MATERIAL_CANT" INTEGER NOT NULL,
    "MATERIAL_PRICE" DOUBLE NOT NULL,
    "MATERIAL_CODE" BIGINT NOT NULL,
    "PRODUCT_CODE" BIGINT NOT NULL
);        
ALTER TABLE "PUBLIC"."PRODUCTDETAILS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_6F" PRIMARY KEY("PRODUCT_DETAIL_CODE");             
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.PRODUCTDETAILS;          
CREATE MEMORY TABLE "PUBLIC"."PRODUCTS"(
    "PRODUCT_CODE" BIGINT DEFAULT NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_CB53AA59_AD63_42D2_9039_3B5842AECFA0" NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_CB53AA59_AD63_42D2_9039_3B5842AECFA0",
    "PRODUCT_CREATE_DATE" TIMESTAMP NOT NULL,
    "PRODUCT_DESCRIPTION" VARCHAR(200) NOT NULL,
    "PRODUCT_TAX" DOUBLE NOT NULL
);         
ALTER TABLE "PUBLIC"."PRODUCTS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_F" PRIMARY KEY("PRODUCT_CODE");           
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.PRODUCTS;
ALTER TABLE "PUBLIC"."INVOICEHEADERS" ADD CONSTRAINT "PUBLIC"."FK687F0NNYL1AJHE8UY9PJG3DXN" FOREIGN KEY("INVOICE_CITY_CODE") REFERENCES "PUBLIC"."CITYS"("CITY_CODE") NOCHECK;
ALTER TABLE "PUBLIC"."PRODUCTDETAILS" ADD CONSTRAINT "PUBLIC"."FKT3O9R43RBBK1V6SX25DRQAAMM" FOREIGN KEY("PRODUCT_CODE") REFERENCES "PUBLIC"."PRODUCTS"("PRODUCT_CODE") NOCHECK;               
ALTER TABLE "PUBLIC"."INVOICEHEADERS" ADD CONSTRAINT "PUBLIC"."FK3MK40T858KHNDKTWWMVP34DWS" FOREIGN KEY("INVOICE_CLIENT_CODE") REFERENCES "PUBLIC"."CLIENTS"("CLIENT_CODE") NOCHECK;          
ALTER TABLE "PUBLIC"."CITYS" ADD CONSTRAINT "PUBLIC"."FKBHL0WYNQ22S0TCX0GX2850JUW" FOREIGN KEY("CITY_DEPARTAMENT_CODE") REFERENCES "PUBLIC"."DEPARTAMENTS"("DEPARTAMENT_CODE") NOCHECK;       
ALTER TABLE "PUBLIC"."INVOICEDETAILS" ADD CONSTRAINT "PUBLIC"."FKFXMCOWBKDFJT06T9FHCMXC3KF" FOREIGN KEY("PRODUCT_CODE") REFERENCES "PUBLIC"."PRODUCTS"("PRODUCT_CODE") NOCHECK;               
ALTER TABLE "PUBLIC"."INVOICEHEADERS" ADD CONSTRAINT "PUBLIC"."FK2501I92LC642MTE6CKX6DD8R4" FOREIGN KEY("INVOICE_DEPARTAMENT_CODE") REFERENCES "PUBLIC"."DEPARTAMENTS"("DEPARTAMENT_CODE") NOCHECK;           
ALTER TABLE "PUBLIC"."PRODUCTDETAILS" ADD CONSTRAINT "PUBLIC"."FKHJDYJQ55L0C442VQQ7FD1WUHJ" FOREIGN KEY("MATERIAL_CODE") REFERENCES "PUBLIC"."MATERIALS"("MATERIAL_CODE") NOCHECK;            
ALTER TABLE "PUBLIC"."CLIENTS" ADD CONSTRAINT "PUBLIC"."FKS11CMEL9LGH7NXMOK7FWJ1DE4" FOREIGN KEY("CLIENT_DEPARTAMENT_CODE") REFERENCES "PUBLIC"."DEPARTAMENTS"("DEPARTAMENT_CODE") NOCHECK;   
ALTER TABLE "PUBLIC"."CLIENTS" ADD CONSTRAINT "PUBLIC"."FKN99JHAUCVISIXUCH10X3SNKR2" FOREIGN KEY("CLIENT_CITY_CODE") REFERENCES "PUBLIC"."CITYS"("CITY_CODE") NOCHECK;        
ALTER TABLE "PUBLIC"."INVOICEDETAILS" ADD CONSTRAINT "PUBLIC"."FKHBFTN5IRIC1YW4JOCBFLRS60R" FOREIGN KEY("INVOICE_NUMBER") REFERENCES "PUBLIC"."INVOICEHEADERS"("INVOICE_NUMBER") NOCHECK;     