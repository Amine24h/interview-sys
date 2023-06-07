drop sequence if exists public.interview_request_seq;
drop sequence if exists public.interview_seq;
drop sequence if exists public.job_position_seq;
drop sequence if exists public.line_of_business_seq;
drop sequence if exists public.recruiter_seq;
drop sequence if exists public.skill_seq;
drop sequence if exists public.technical_advisor_seq;

alter table if exists interview drop constraint if exists FKspumivokcps1jknhh9px96b9v;
alter table if exists interview drop constraint if exists FKaehscqyahewafrvlq1hpqfa5o;
alter table if exists interview_request drop constraint if exists FKg1uj9pwqtp1q7wsyoocbprg1e;
alter table if exists interview_request drop constraint if exists FKp0dbxylcme5gsp0buoj449oy3;
alter table if exists job_position drop constraint if exists FKe00dsovy7ptmi2rfafh781nrd;
alter table if exists job_position drop constraint if exists FKssqhpa7uknghsh5gea3v69l3m;
alter table if exists skill drop constraint if exists FKcutqxhrndih5w96b2mpjuh525;
alter table if exists skill drop constraint if exists FKki8lcnay1y8np8mkef0avpbvs;

drop table if exists interview cascade;
drop table if exists interview_request cascade;
drop table if exists job_position cascade;
drop table if exists line_of_business cascade;
drop table if exists recruiter cascade;
drop table if exists skill cascade;
drop table if exists technical_advisor cascade;

create sequence public.interview_request_seq start with 1 increment by 1;
create sequence public.interview_seq start with 1 increment by 1;
create sequence public.job_position_seq start with 1 increment by 1;
create sequence public.line_of_business_seq start with 1 increment by 1;
create sequence public.recruiter_seq start with 1 increment by 1;
create sequence public.skill_seq start with 1 increment by 1;
create sequence public.technical_advisor_seq start with 1 increment by 1;

create table interview (urgent boolean, id bigint not null, job_position_id bigint, recruiter_id bigint, description varchar(255), person_to_interview varchar(255) not null, status varchar(255) check (status in ('JUNIOR','INTERMEDIATE','SENIOR','SENIOR_PLUS','EXPERT')), primary key (id));
create table interview_request (response_order integer, id bigint not null, interview_id bigint, request_date timestamp(6), response_date timestamp(6), technical_advisor_id bigint, comment varchar(255), status varchar(255) check (status in ('PENDING','ACCEPTED','REJECTED','REJECTED_BY_RECRUITER','ASSIGNED')), primary key (id));
create table job_position (id bigint not null, line_of_business_id bigint, parent_id bigint, name varchar(255) not null, primary key (id));
create table line_of_business (id bigint not null, name varchar(255) not null, primary key (id));
create table recruiter (active boolean, id bigint not null, email varchar(255), name varchar(255) not null, primary key (id));
create table skill (id bigint not null, job_position_id bigint, technical_advisor_id bigint, level_of_expertise varchar(255) check (level_of_expertise in ('JUNIOR','INTERMEDIATE','SENIOR','SENIOR_PLUS','EXPERT')), primary key (id));
create table technical_advisor (active boolean, id bigint not null, email varchar(255), name varchar(255) not null, primary key (id));

alter table if exists interview add constraint FKspumivokcps1jknhh9px96b9v foreign key (job_position_id) references job_position;
alter table if exists interview add constraint FKaehscqyahewafrvlq1hpqfa5o foreign key (recruiter_id) references recruiter;
alter table if exists interview_request add constraint FKg1uj9pwqtp1q7wsyoocbprg1e foreign key (interview_id) references interview;
alter table if exists interview_request add constraint FKp0dbxylcme5gsp0buoj449oy3 foreign key (technical_advisor_id) references technical_advisor;
alter table if exists job_position add constraint FKe00dsovy7ptmi2rfafh781nrd foreign key (line_of_business_id) references line_of_business;
alter table if exists job_position add constraint FKssqhpa7uknghsh5gea3v69l3m foreign key (parent_id) references job_position;
alter table if exists skill add constraint FKcutqxhrndih5w96b2mpjuh525 foreign key (job_position_id) references job_position;
alter table if exists skill add constraint FKki8lcnay1y8np8mkef0avpbvs foreign key (technical_advisor_id) references technical_advisor;