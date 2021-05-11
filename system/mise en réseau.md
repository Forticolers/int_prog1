```
---192.168.122.22 : IP of vm1 ;
ubuntu@C2:~$ ssh -N -L  2222:192.168.122.64:22 ubuntu@10.0.3.106
ubuntu@10.0.3.106's password: 
^Z
[1]+  Stopped                 ssh -N -L 2222:192.168.122.64:22 ubuntu@10.0.3.106
ubuntu@C2:~$ ssh ubuntu@localhost -p 2222


^C
ubuntu@C2:~$ bg
[1]+ ssh -N -L 2222:192.168.122.64:22 ubuntu@10.0.3.106 &
ubuntu@C2:~$ ssh ubuntu@localhost -p 2222
The authenticity of host '[localhost]:2222 ([::1]:2222)' can't be established.
ECDSA key fingerprint is SHA256:fc5L1FzQpe7q0oilfHXE4dWKT43FE2ZtSOz2hPRltJ0.
Are you sure you want to continue connecting (yes/no/[fingerprint])? yes
Warning: Permanently added '[localhost]:2222' (ECDSA) to the list of known hosts.
ubuntu@localhost's password: 

```

