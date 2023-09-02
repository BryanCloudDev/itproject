export class BookRequest {
  constructor(
    public name: string,
    public authorId: number,
    public categoryId: number,
    public price: number,
    public status?: boolean
  ) {}
}
