import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { ApiService } from 'src/app/services/api-service.service';

@Component({
  selector: 'app-home',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  constructor(private router: Router, private apiService: ApiService) {}

  // username: string = '';
  // password: string = '';
  // errorMessage: string = '';

  // login(): void {
  //   if (this.username === 'admin' && this.password === 'admin') {
  //     this.router.navigate(['/view-tickets']);
  //   } else {
  //     this.errorMessage = 'Invalid credentials. Please try again.';
  //     alert('Invalid Credentials');
  //   }
  // }

  user: User = new User();

  ngOnInit(): void {}

  login() {
    this.apiService.login(this.user).subscribe({
      next: (response: any) => {
        console.log('Login Response:', response);

        // ✅ Store userId instead of token
        if (response && response.userId) {
          localStorage.setItem('user', JSON.stringify(response));
        }

        alert('Login Successful!');
        this.router.navigate(['/view-tickets']); // force redirect
      },
      error: () => {
        alert('Invalid username or password');
      },
    });
  }
}
