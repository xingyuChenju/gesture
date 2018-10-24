close all 
clear all 
addpath('functions')
addpath('../Reader/Data')
file_name = 'demo3.txt';
epc_col = 1; 
phase_col = 2;
rssi_col = 3;
time_col = 4;
data = load(file_name)
figure 
plot(data(:,time_col),data(:,phase_col))
figure 
plot(data(:,time_col),data(:,rssi_col))
