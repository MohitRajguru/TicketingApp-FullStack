import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Tickets } from 'src/app/model/tickets';
import { ApiService } from 'src/app/services/api-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-tickets',
  templateUrl: './view-tickets.component.html',
  styleUrls: ['./view-tickets.component.css'],
})
export class ViewTicketsComponent implements OnInit {
  currentPage: number = 1;
  itemsPerPage: number = 10;

  Math = Math;

  isAdminLoggedIn = new BehaviorSubject<boolean>(false);
  selectedTickets: string[] = [];
  tickets: Tickets[] = [];

  @Input() ticket: Tickets = new Tickets();
  @Output() deleteEvent: EventEmitter<string> = new EventEmitter();

  constructor(private apiService: ApiService, private router: Router) {}

  ngOnInit(): void {
    this.apiService.viewTickets().subscribe({
      next: (data) => {
        this.tickets = data;
      },
      error: (error) => {
        console.log(error);
      },
    });
    this.isAdminLoggedIn.next(true);
  }

  toggleCheckbox(ticket: Tickets): void {
    const index = this.selectedTickets.indexOf(ticket.ticketId);
    if (index === -1) {
      this.selectedTickets.push(ticket.ticketId);
    } else {
      this.selectedTickets.splice(index, 1);
    }
  }

  isSelected(ticket: Tickets): boolean {
    return this.selectedTickets.includes(ticket.ticketId);
  }

  toggleSelectAll(event: any): void {
    if (event.target.checked) {
      this.selectedTickets = this.tickets.map((t) => t.ticketId);
    } else {
      this.selectedTickets = [];
    }
  }

  isAllSelected(): boolean {
    return (
      this.selectedTickets.length === this.tickets.length &&
      this.tickets.length > 0
    );
  }

  deleteSelectedTickets(): void {
    if (this.selectedTickets.length === 0) return;

    if (confirm(`Delete ${this.selectedTickets.length} selected ticket(s)?`)) {
      this.selectedTickets.forEach((ticketId) => {
        this.apiService.deleteTicket(ticketId).subscribe({
          next: () => {
            this.tickets = this.tickets.filter((t) => t.ticketId !== ticketId);
          },
          error: (error) => {
            console.log(error);
          },
        });
      });

      alert('Selected tickets deleted successfully.');
      this.selectedTickets = [];
    }
  }

  editTicket(ticketId: string): void {
    // this.router.navigate(['/edit-ticket', ticketId]);
    alert(`Edit feature is under development for now, please come back later.`);
  }

  onPageChange(page: number) {
    this.currentPage = page;
  }
}
