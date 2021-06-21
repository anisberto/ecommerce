export class Order {
    id: any;
    address: any;
    moment: any;
    status: any;
    total: any;
    shipping: any;
    products: any[] = [];
}

export class OrderDTO {
    address: any;
    total: any;
    products: any[] = [];
}