import { Component } from '@angular/core';
import { ApiService } from 'src/app/services/api-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent {
  user = {
    userId: '',
    password: '',
  };

  constructor(private apiService: ApiService, private router: Router) {}

  registerUser() {
    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    const userPattern = /^[a-zA-Z0-9_]{8,}$/;
    const passwordPattern =
      /^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\S+$).{8,}$/;

    if (!userPattern.test(this.user.userId)) {
      alert(
        'Username must be at least 8 characters (letters, numbers, _ only)'
      );
      return;
    }
    if (!passwordPattern.test(this.user.password)) {
      alert(
        'Password must have uppercase, lowercase, digit, special char, and be 8+ characters'
      );
      return;
    }

    this.apiService.registerUser(this.user).subscribe({
      next: () => {
        alert('Registration successful');
        this.router.navigate(['/login']);
      },
      error: () => {
        alert('Registration failed. Please try again.');
      },
    });
  }
}
